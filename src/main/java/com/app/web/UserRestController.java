package com.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.domain.User;
import com.app.encryption.MD5;
import com.app.repository.UserRepository;

@RestController

@PreAuthorize("hasRole('ADMIN')")
@RequestMapping(value = "/")
public class UserRestController extends AuditLogSupport {
	@Autowired
	private UserRepository ligUserRepository;

	/**
	 * 用户列表
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public Page<User> list(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "count", defaultValue = "10000") Integer size,
			@RequestParam(value = "sort", defaultValue = "ASC") String sortname) {

		Sort sort = new Sort(Direction.fromString(sortname), "id");
		Pageable pageable = new PageRequest(page, size, sort);

		return ligUserRepository.findAll(pageable);
	}

	/**
	 * 单个用户信息
	 * 
	 * @param id
	 * @return
	 */

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> userById(@PathVariable Long id) {
		User ligUser = ligUserRepository.findOne(id);
		if (ligUser == null) {
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<User>(ligUser, HttpStatus.OK);
		}
	}

	/**
	 * 删除用户
	 */
	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(@PathVariable Long id) {
		User ligUser = ligUserRepository.findOne(id);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedUsername = auth.getName();
		if (ligUser == null) {
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		} else if (ligUser.getUsername().equalsIgnoreCase(loggedUsername)) {
			throw new RuntimeException("You cannot delete your account");
		} else {
			ligUserRepository.delete(ligUser);
			return new ResponseEntity<User>(ligUser, HttpStatus.OK);
		}

	}

	/**
	 * 增加用户
	 * 
	 * @param ligUser
	 * @return
	 */
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody User ligUser) {
		if (ligUserRepository.findOneByUsername(ligUser.getUsername()) != null) {
			log("增加用户" + ligUser.getUsername() + "", "失败，用户" + "已存在");
			throw new RuntimeException("用户" + ligUser.getUsername() + "已存在");
		}

		log("增加用户" + ligUser.getUsername() + "", "成功");
		return new ResponseEntity<User>(ligUserRepository.save(ligUser), HttpStatus.CREATED);
	}

	/**
	 * 修改用户
	 * 
	 * @param ligUser
	 * @return
	 */

	@RequestMapping(value = "/users", method = RequestMethod.PUT)
	public User updateUser(@RequestBody User ligUser) {
		User u = ligUserRepository.findOne(ligUser.getId());
		if (u == null) {
			log("修改用户" + ligUser.getUsername() + "角色", "失败，用户" + "不存在");
			throw new RuntimeException("Username no exist");
		}
		u.setRole(ligUser.getRole());
		log("修改用户" + u.getUsername() + "角色", "成功");
		return ligUserRepository.save(u);
	}

	/**
	 * 启用用户
	 * 
	 * @param id
	 * @return
	 */

	@RequestMapping(value = "/users/{id}/enable", method = RequestMethod.POST)
	public User enableUser(@PathVariable Long id) {
		User ligUser = ligUserRepository.findOne(id);

		if (ligUser == null) {
			throw new RuntimeException("Username not  exist");
		} else {
			log("启用用户" + ligUser.getUsername() + "", "成功");
			ligUser.setEnable(true);
		}
		return ligUserRepository.save(ligUser);
	}

	/**
	 * 禁用用户
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/users/{id}/disable", method = RequestMethod.POST)
	public User disableUser(@PathVariable Long id) {
		User ligUser = ligUserRepository.findOne(id);

		if (ligUser == null) {
			throw new RuntimeException("Username not  exist");
		} else {
			log("禁用用户" + ligUser.getUsername() + "", "成功");
			ligUser.setEnable(false);
		}
		return ligUserRepository.save(ligUser);
	}

	@RequestMapping(value = "/users/password/admin", method = RequestMethod.PUT)
	public ResponseEntity<User> password(@RequestParam String opassword, @RequestParam String npassword) {
		User ligUser = ligUserRepository.findOneByUsername("admin");
		if (ligUser != null && ligUser.getPassword().equals(MD5.getMd5(opassword))) {
			ligUser.setPassword(npassword);
			log("修改管理员密码",  "成功");
			return new ResponseEntity<User>(ligUserRepository.save(ligUser), HttpStatus.OK);
		} else {
			log("修改管理员密码", "失败");
			throw new RuntimeException("修改失败");
		}

	}

	@RequestMapping(value = "/users/password", method = RequestMethod.PUT)
	public ResponseEntity<User> password(@RequestParam Long id, @RequestParam String password) {
		User ligUser = ligUserRepository.findOne(id);
		if (ligUser != null) {
			ligUser.setPassword(password);
			log("修改用户" + ligUser.getUsername() + "密码", "成功");
			return new ResponseEntity<User>(ligUserRepository.save(ligUser), HttpStatus.OK);
		} else {
			log("修改用户" + ligUser.getUsername() + "密码", "失败");
			throw new RuntimeException("修改失败");
		}

	}

}
