package hh_sof03.bookstore2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import hh_sof03.bookstore2.web.BookController;

@SpringBootTest
class Bookstore2ApplicationTests {

	@Autowired
    private BookController controller;

	@Test
	public void contexLoads() throws Exception {
	assertThat(controller).isNotNull();
 } 

}
