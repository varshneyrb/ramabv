package com.example;

import org.springframework.data.repository.CrudRepository;

interface BookRepository extends CrudRepository<Book, Integer>
{

	Book getOne(int id);

}
