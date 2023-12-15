package com.firstapp.jsonplaceholder;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient( value = "jsonplaceholder",
			  url = "https://jsonplaceholder.typicode.com/")
/*
 * Uses Open-Fign Client to fetch posts from JSONPlaceHolder
*/
public interface JSONPlaceHolderClient {
	
	@GetMapping("posts")
	List<Post> getPosts();
	
	@GetMapping("posts/{postId}")
	Post getPost(@PathVariable Integer postId);

}
