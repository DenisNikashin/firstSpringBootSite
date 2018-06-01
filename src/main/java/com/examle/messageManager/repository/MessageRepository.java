package com.examle.messageManager.repository;

import com.examle.messageManager.domaine.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {

}
