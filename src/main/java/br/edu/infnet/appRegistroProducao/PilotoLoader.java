package br.edu.infnet.appRegistroProducao;

import br.edu.infnet.appRegistroProducao.model.domain.Piloto;
import br.edu.infnet.appRegistroProducao.model.service.PilotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Component
public class PilotoLoader implements ApplicationRunner {

    @Autowired
    private PilotoService pilotoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/pilotos.txt");
        BufferedReader br = new BufferedReader(file);
        br.close();

        String line = br.readLine();
        String[] campos = null;

        while (line != null){
            campos = line.split(";");
            System.out.println(line);
            line = br.readLine();
            Piloto piloto =new Piloto();
            piloto.setSku(campos[0]);
            piloto.setNome(campos[1]);
            piloto.setTempoProducao(Float.parseFloat(campos[2]));
            piloto.setValorMaoDeObra(Float.parseFloat(campos[3]));
            piloto.setValorMaoDeObra(Float.parseFloat(campos[3]));
            piloto.setCustoTotalMateriais(Float.parseFloat(campos[4]));
            piloto.setCustoTotalMaoDeObra(Float.parseFloat(campos[5]));
            piloto.setCustoTotalProduto(Float.parseFloat(campos[6]));
            piloto.setAprovado(Boolean.parseBoolean(campos[7]));

            pilotoService.incluir(piloto);

            line = br.readLine();
        }

        for(Piloto p : pilotoService.obterLista()){
            System.out.println(p);
        }
        br.close();
    }
}
