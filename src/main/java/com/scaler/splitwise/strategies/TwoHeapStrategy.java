package com.scaler.splitwise.strategies;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.ArrayList;

import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import com.scaler.splitwise.models.Transaction;
import com.scaler.splitwise.models.User;

@Component
public class TwoHeapStrategy implements SettleUpStrategy{

	@Override
	public List<Transaction> settleUp(Map<User, Double> condensedExpenses) {
		Queue<Pair<User, Double>> minHeap = new PriorityQueue<>((a, b) -> (int)(a.getSecond() - b.getSecond()));
		Queue<Pair<User, Double>> maxHeap = new PriorityQueue<>((a, b) -> (int)(b.getSecond() - a.getSecond()));
		
		for(Entry<User,Double> entry: condensedExpenses.entrySet()) {
			if(entry.getValue() > 0) {
				maxHeap.add(Pair.of(entry.getKey(), entry.getValue()));
			}else {
				minHeap.add(Pair.of(entry.getKey(), entry.getValue()));
			}
		}
		
		List<Transaction> transactions = new ArrayList<>();
		
		while(!minHeap.isEmpty() && !maxHeap.isEmpty()) {
			Pair<User, Double> userToBePaid = maxHeap.poll();
			Pair<User, Double> userToPay = minHeap.peek();
			
			double amountToBeTransfered = Math.min(userToBePaid.getSecond(), Math.abs(userToPay.getSecond()));
			
			Transaction transaction = new Transaction();
			transaction.setAmount(amountToBeTransfered);
			transaction.setPaidFrom(userToPay.getFirst());
			transaction.setPaidTo(userToBePaid.getFirst());
			transaction.setAmount(amountToBeTransfered);
			transactions.add(transaction);
			
			if(userToBePaid.getSecond() - amountToBeTransfered> 0) {
				maxHeap.add(Pair.of(userToBePaid.getFirst(), userToBePaid.getSecond() - amountToBeTransfered));
			}
			
			if(userToPay.getSecond() + amountToBeTransfered < 0) {
				minHeap.add(Pair.of(userToPay.getFirst(), userToPay.getSecond() + amountToBeTransfered));
			}
			
		
		}
		
		
		return transactions;
	}

}
