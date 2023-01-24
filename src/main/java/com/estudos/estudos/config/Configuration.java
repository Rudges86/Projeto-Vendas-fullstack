package com.estudos.estudos.config;

import com.estudos.estudos.domain.entity.Categoria;
import com.estudos.estudos.domain.entity.Produto;
import com.estudos.estudos.domain.entity.User;
import com.estudos.estudos.domain.repository.CategoriaRepository;
import com.estudos.estudos.domain.repository.ProdutoRepository;
import com.estudos.estudos.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@org.springframework.context.annotation.Configuration
@Profile("dev")
public class Configuration implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Override
    public void run(String... args) throws Exception {
        User user = new User(null,"Rudge","rudges@gmail.com","132540","ruyasdas");
        User user2 = new User(null,"Valdinete","valval@gmail.com","132540","valval");

        userRepository.saveAll(Arrays.asList(user,user2));

        Categoria ct1 = new Categoria(null,"laticionio");
        Categoria ct2 = new Categoria(null,"laticionio diferente");

        categoriaRepository.saveAll(Arrays.asList(ct1,ct2));

        Produto p1 = new Produto(null, "Leite","Leite de vaca",5.00 ,ct1);
        Produto p2 = new Produto(null, "Leite","Leite de bode",5.00 ,ct2);
        produtoRepository.saveAll(Arrays.asList(p1,p2));


    }
}
