package com.acunmedya_jvrfs1.Library.Repository;


import com.acunmedya_jvrfs1.Library.entity.productEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;



@Repository
public interface ProductRepository extends JpaRepository<productEntity,Integer>{

}

aaa