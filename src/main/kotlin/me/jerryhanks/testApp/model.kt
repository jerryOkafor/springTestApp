package me.jerryhanks.testApp

import javax.persistence.*
import java.util.HashSet
import javax.persistence.ManyToMany



@Entity
class Author(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,

        val firstName:String,

        val lastName:String){

    @ManyToMany(mappedBy = "authors")
    lateinit var books:Set<Book>
}

@Entity
class Book(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,

        val title:String,

        val isbn:String,

        val publisher:String){

    @ManyToMany
    @JoinTable(name = "author_book",joinColumns = [JoinColumn(name = "book_id")],
            inverseJoinColumns = [JoinColumn(name = "author_id")])
     lateinit var authors:Set<Author>
}