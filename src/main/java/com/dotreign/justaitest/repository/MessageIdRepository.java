package com.dotreign.justaitest.repository;

import com.dotreign.justaitest.model.MessageId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий Redis с ключами сообщений для дедупликации
 */
@Repository
public interface MessageIdRepository extends CrudRepository<MessageId, String> {

}
