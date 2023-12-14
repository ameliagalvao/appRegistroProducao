package br.edu.infnet.appRegistroProducao;

import br.edu.infnet.appRegistroProducao.model.domain.ProdutoAptoProducao;
import br.edu.infnet.appRegistroProducao.model.service.ProdutoAptoProducaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Component
public class ProdutoAptoProducaoLoader implements ApplicationRunner {

    @Autowired
    private ProdutoAptoProducaoService produtoAptoProducaoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            // Load the file from the classpath
            ClassPathResource resource = new ClassPathResource("files/produtosaptos.txt");
            InputStream inputStream = resource.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

            String line = br.readLine();
            String[] campos;

            while (line != null) {
                campos = line.split(";");
                System.out.println(line);

                ProdutoAptoProducao produto = new ProdutoAptoProducao();
                produto.setSku(campos[0]);
                produto.setNome(campos[1]);
                produto.setTempoProducao(Float.parseFloat(campos[2]));
                produto.setValorMaoDeObra(Float.parseFloat(campos[3]));
                produto.setCustoTotalMateriais(Float.parseFloat(campos[4]));
                produto.setCustoTotalMaoDeObra(Float.parseFloat(campos[5]));
                produto.setCustoTotalProduto(Float.parseFloat(campos[6]));
                produto.setLucro(Float.parseFloat(campos[8]));
                produto.setPrecoFinal(Float.parseFloat(campos[9]));

                produtoAptoProducaoService.incluir(produto);

                line = br.readLine();
            }

            for (ProdutoAptoProducao p : produtoAptoProducaoService.obterLista()) {
                System.out.println(p);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
