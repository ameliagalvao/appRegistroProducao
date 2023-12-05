package br.edu.infnet.appRegistroProducao;

import br.edu.infnet.appRegistroProducao.model.domain.Artesao;
import br.edu.infnet.appRegistroProducao.model.service.ArtesaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Component
public class ArtesaoLoader implements ApplicationRunner {

    @Autowired
    private ArtesaoService artesaoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/artesaos.txt");
        BufferedReader br = new BufferedReader(file);

        String line = br.readLine();
        String[] campos = null;

        while (line != null){
            campos = line.split(";");
            System.out.println(line);
            line = br.readLine();
            Artesao artesao =new Artesao();
            artesao.setNome(campos[0]);
            artesao.setCpf(campos[1]);
            artesao.setTelefone(campos[4]);

            artesaoService.incluir(artesao);

            line = br.readLine();
        }

        for(Artesao a : artesaoService.obterLista()){
            System.out.println(a);
        }
        br.close();
    }
}
