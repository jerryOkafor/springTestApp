package me.jerryhanks.testApp

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component

@Component
class DevBootstrap : ApplicationListener<ContextRefreshedEvent>{

    @Autowired lateinit var authorRepository: AuthorRepository
    @Autowired lateinit var bookRepository: BookRepository

    override fun onApplicationEvent(event: ContextRefreshedEvent) {
        initDB()
    }

    private fun initDB(){
        print("Init Dummy DB")
        //Eric
        val eric = Author(0L,"Eric","Evans")
        val ddd  = Book(0L, "Domain Driven Design","1234","Harper Collins")

        authorRepository.save(eric)
        bookRepository.save(ddd)


        //Rod
        val rod = Author(0L,"Rod","Johnson")
        val noEJB  = Book(0L, "J2EE Development without EJB","1235","Wrox")

        authorRepository.save(rod)
        bookRepository.save(noEJB)

    }
}