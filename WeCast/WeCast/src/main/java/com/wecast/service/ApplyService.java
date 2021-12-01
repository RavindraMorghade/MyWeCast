package com.wecast.service;

import java.util.List;

import com.wecast.exception.ServiceException;
import com.wecast.request.Apply;
import com.wecast.request.User;

public interface ApplyService{

	public Apply applyJob(Apply apply) throws ServiceException;
	
	public List<User> retrieveApplyBy(int job_id) throws ServiceException;

	public Apply selectUserForProject(int jobId, int userId);

	public List<User> findSelectedUsers(int jobId) throws ServiceException;

}
