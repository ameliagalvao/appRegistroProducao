package br.edu.infnet.appRegistroProducao.model.domain;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

@Component
public class ArtesaoLoader implements ApplicationRunner {

    private Map<String, Artesao> mapa = new HashMap<String, Artesao>();

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/artesaos.txt");
        BufferedReader br = new BufferedReader(file);
        br.close();

        String line = br.readLine();
        String[] campos = null;

        while (line != null){
            campos = line.split(";");
            System.out.println(line);
            line = br.readLine();
            Artesao a =new Artesao();
            a.setNome(campos[0]);
            a.setCpf(campos[1]);
            a.setTelefone(campos[4]);

            mapa.put(a.getCpf(), a);

            line = br.readLine();
        }

        for (String cpf : mapa.keySet()){
            System.out.println(cpf);
        }

        for(Artesao a : mapa.values()){
            System.out.println(a);
        }
        br.close();
    }
}
