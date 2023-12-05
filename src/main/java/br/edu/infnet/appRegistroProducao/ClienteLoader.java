package br.edu.infnet.appRegistroProducao;

import br.edu.infnet.appRegistroProducao.model.domain.Cliente;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

@Component
public class ClienteLoader implements ApplicationRunner {

    private Map<String, Cliente> mapa = new HashMap<String, Cliente>();

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/clientes.txt");
        BufferedReader br = new BufferedReader(file);
        br.close();

        String line = br.readLine();
        String[] campos = null;

        while (line != null){
            campos = line.split(";");
            System.out.println(line);
            line = br.readLine();
            Cliente c =new Cliente();
            c.setNome(campos[0]);
            c.setCnpjOuCpf(campos[1]);
            c.setTelefone(campos[2]);
            c.setEmail(campos[3]);

            mapa.put(c.getCnpjOuCpf(), c);

            line = br.readLine();
        }

        for (String cpfOuCnpj : mapa.keySet()){
            System.out.println(cpfOuCnpj);
        }

        for(Cliente c : mapa.values()){
            System.out.println(c);
        }
        br.close();
    }
}
