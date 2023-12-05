package br.edu.infnet.appRegistroProducao.model.domain;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

@Component
public class ProdutoAptoProducaoLoader implements ApplicationRunner {

    private Map<String, ProdutoAptoProducao> mapa = new HashMap<String, ProdutoAptoProducao>();

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/produtosaptos.txt");
        BufferedReader br = new BufferedReader(file);
        br.close();

        String line = br.readLine();
        String[] campos = null;

        while (line != null){
            campos = line.split(";");
            System.out.println(line);
            line = br.readLine();
            ProdutoAptoProducao p =new ProdutoAptoProducao();
            p.setSku(campos[0]);
            p.setNome(campos[1]);
            p.setTempoProducao(Float.parseFloat(campos[2]));
            p.setValorMaoDeObra(Float.parseFloat(campos[3]));
            p.setValorMaoDeObra(Float.parseFloat(campos[3]));
            p.setCustoTotalMateriais(Float.parseFloat(campos[4]));
            p.setCustoTotalMaoDeObra(Float.parseFloat(campos[5]));
            p.setCustoTotalProduto(Float.parseFloat(campos[6]));
            p.setLucro(Float.parseFloat(campos[8]));
            p.setPrecoFinal(Float.parseFloat(campos[9]));
            mapa.put(p.getSku(), p);

            line = br.readLine();
        }

        for (String sku : mapa.keySet()){
            System.out.println(sku);
        }

        for(ProdutoAptoProducao p : mapa.values()){
            System.out.println(p);
        }
        br.close();
    }
}
