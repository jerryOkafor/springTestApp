package me.jerryhanks.testApp

import org.springframework.data.repository.CrudRepository

interface AuthorRepository : CrudRepository<Author,Long>

interface  BookRepository : CrudRepository<Book,Long>