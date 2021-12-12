package com.repo;

import com.model.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepo extends PagingAndSortingRepository<Blog,Long> {
}
