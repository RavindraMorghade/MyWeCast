package com.wecast.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.wecast.exception.ServiceException;
import com.wecast.repo.ApplyRepository;
import com.wecast.repo.UserRepository;
import com.wecast.request.Apply;
import com.wecast.request.User;
import com.wecast.service.ApplyService;

@Service
public class ApplyServiceImpl implements ApplyService {

	@Autowired
	private ApplyRepository applyRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public Apply applyJob(Apply apply) {
		Apply a = applyRepository.save(apply);
		return a;
	}

	@Override
	public List<User> retrieveApplyBy(int job_id) throws ServiceException {
		List<Integer> userlist = new ArrayList<>();
		List<Apply> list = applyRepository.findByJobId(job_id);
		if (list.isEmpty()) {
			throw new ServiceException("Record not found");
		} else {
			for(Apply apply :list) {
				userlist.add(apply.getUserId());
			}
			List<User> uList = userRepository.findAllUsers(userlist);
			return uList;
		}
	}
	
	@Override
	public Apply selectUserForProject(int jobId, int userId) {
		Apply returnApply = null;
		Apply a = applyRepository.findStatus(jobId, userId);
		if(a!=null) {
			a.setStatus("Selected");
			 returnApply = applyRepository.save(a);
		}
		return returnApply;
		
	}
	
	@Override
	public List<Apply> findSelectedUsers(int jobId){
		 List<Apply> l = applyRepository.findSelectedUsers(jobId);
		return l;
		
	}


}
