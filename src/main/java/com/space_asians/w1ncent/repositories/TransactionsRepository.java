package com.space_asians.w1ncent.repositories;

import com.space_asians.w1ncent.entities.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepository extends CrudRepository<Transaction, Integer> {
    // @Query("SELECT * FROM TRANSACTIONS WHERE WHO=\"Firuz\"")
    // public List<String> findAllByMember();

    @Query(value = "SELECT * FROM transactions ORDER BY `when` DESC", nativeQuery = true)
    public Iterable<Transaction> findAllOrderByWhenAsc();

    public Transaction findTopByOrderByIdDesc();

    public Iterable<Transaction> findAllByWho(String who);

    @Query(value = "SELECT * FROM transactions WHERE who= ?1 OR whom=?1 ORDER BY `when` ASC", nativeQuery = true)
    public Iterable<Transaction> findHistory(String member);

    // @Query(value = "SELECT previous_transactions FROM members WHERE chat_id = ?1", nativeQuery = true)
    // public int[] findPreviousTransactionsByChatId(Long chat_id);


}
