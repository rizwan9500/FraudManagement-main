package com.mvc.fraudmanagement.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.fraudmanagement.entities.Transaction;
import com.mvc.fraudmanagement.repos.TransactionRepository;

@Service
public class TransactionService {
    private List<Transaction> transactionList = new ArrayList<>();
    @Autowired
    public TransactionRepository transactionRepository;

    public void getAllTransaction() {
        transactionList = transactionRepository.findAll();
    }

    public Transaction getTransactionById(int id) {
        getAllTransaction();
        for (Transaction transaction : transactionList) {
            if (transaction.getId() == id) {
                return transaction;
            }
        }
        return null;
    }

    public void deleteTransaction(int id) {
        Transaction transaction = getTransactionById(id);
        if (transaction.getId() == id) {
            transactionRepository.delete(transaction);
        }
    }

    public List<Transaction> showAllTransactionFraud() {
        List<Transaction> transactions = new ArrayList<>();
        getAllTransaction();
        for (Transaction t : transactionList) {
            transactions.add(t);
        }
        return transactions;
    }

    public Transaction getTransactionByUserId(String id) {
        getAllTransaction();
        for (Transaction transaction : transactionList) {
            if (transaction.getUserId().equals(id)) {
                return transaction;
            }
        }
        return null;
    }
}
