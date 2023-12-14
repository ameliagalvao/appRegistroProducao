package br.edu.infnet.appRegistroProducao;

import br.edu.infnet.appRegistroProducao.model.domain.Piloto;
import br.edu.infnet.appRegistroProducao.model.service.PilotoService;
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
public class PilotoLoader implements ApplicationRunner {

    @Autowired
    private PilotoService pilotoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            // Load the file from the classpath
            ClassPathResource resource = new ClassPathResource("files/pilotos.txt");
            InputStream inputStream = resource.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

            String line = br.readLine();
            String[] campos;

            while (line != null) {
                campos = line.split(";");
                System.out.println(line);

                Piloto piloto = new Piloto();
                piloto.setSku(campos[0]);
                piloto.setNome(campos[1]);
                piloto.setTempoProducao(Float.parseFloat(campos[2]));
                piloto.setValorMaoDeObra(Float.parseFloat(campos[3]));
                piloto.setCustoTotalMateriais(Float.parseFloat(campos[4]));
                piloto.setCustoTotalMaoDeObra(Float.parseFloat(campos[5]));
                piloto.setCustoTotalProduto(Float.parseFloat(campos[6]));
                piloto.setAprovado(Boolean.parseBoolean(campos[7]));

                pilotoService.incluir(piloto);

                line = br.readLine();
            }

            for (Piloto p : pilotoService.obterLista()) {
                System.out.println(p);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
