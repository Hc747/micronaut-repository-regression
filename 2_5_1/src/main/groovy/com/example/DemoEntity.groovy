package com.example

import io.micronaut.context.annotation.Executable
import io.micronaut.data.annotation.Query
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "dual")
class DemoEntity {

    @Id
    Integer id

    @Repository
    static interface DemoRepository extends CrudRepository<DemoEntity, Integer> {

        @Executable
        @Query(value = "INSERT INTO DemoEntity (id) VALUES (1), (2), (3)", readOnly = false)
        long insertExample()

        @Executable
        @Query(value = "UPDATE DemoEntity SET id = 1", readOnly = false)
        long updateExample()

        @Executable
        @Query(value = "DELETE FROM DemoEntity", readOnly = false)
        long deleteExample()
    }
}