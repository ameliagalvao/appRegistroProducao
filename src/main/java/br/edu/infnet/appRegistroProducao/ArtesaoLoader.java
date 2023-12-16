package br.edu.infnet.appRegistroProducao;

import br.edu.infnet.appRegistroProducao.model.domain.Artesao;
import br.edu.infnet.appRegistroProducao.model.service.ArtesaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Order(3)
@Component
public class ArtesaoLoader implements ApplicationRunner {

    @Autowired
    private ArtesaoService artesaoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            // Load the file from the classpath
            ClassPathResource resource = new ClassPathResource("files/artesaos.txt");
            InputStream inputStream = resource.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

            String line = br.readLine();
            String[] campos;

            while (line != null) {
                campos = line.split(";");
                System.out.println(line);

                Artesao artesao = new Artesao();
                artesao.setNome(campos[0]);
                artesao.setCpf(campos[1]);
                artesao.setTelefone(campos[4]);

                artesaoService.incluir(artesao);

                line = br.readLine();
            }

            for (Artesao a : artesaoService.obterLista()) {
                System.out.println(a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
