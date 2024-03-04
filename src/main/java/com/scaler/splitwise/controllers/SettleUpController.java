package com.scaler.splitwise.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.scaler.splitwise.dtos.ResponseStatus;
import com.scaler.splitwise.dtos.SettleGroupRequestDto;
import com.scaler.splitwise.dtos.SettleGroupResponseDto;
import com.scaler.splitwise.dtos.SettleUserRequestDto;
import com.scaler.splitwise.dtos.SettleUserResponseDto;
import com.scaler.splitwise.models.Transaction;
import com.scaler.splitwise.services.SettleUpService;

@Controller
public class SettleUpController {
	
	private SettleUpService settleUpService;
	
	@Autowired
	public SettleUpController(SettleUpService settleUpService) {
		this.settleUpService = settleUpService;
	}
	
	public SettleGroupResponseDto settleGroup(SettleGroupRequestDto requestDto) {
		
		SettleGroupResponseDto settleGroupResponseDto = new SettleGroupResponseDto();
		List<Transaction> transactions = settleUpService.settleGroup(requestDto.getGroupId());
		settleGroupResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
		settleGroupResponseDto.setTransactions(transactions);
		return settleGroupResponseDto;
	}
	
	public SettleUserResponseDto settleUser(SettleUserRequestDto requestDto) {
		
		SettleUserResponseDto settleUserResponseDto = new SettleUserResponseDto();
		List<Transaction> transactions = settleUpService.settleUser(requestDto.getUserId());
		settleUserResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
		settleUserResponseDto.setTransactions(transactions);
		return settleUserResponseDto;
	}

}
