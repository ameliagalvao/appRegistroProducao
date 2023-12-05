package br.edu.infnet.appRegistroProducao;

import br.edu.infnet.appRegistroProducao.model.domain.Cliente;
import br.edu.infnet.appRegistroProducao.model.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Component
public class ClienteLoader implements ApplicationRunner {

    @Autowired
    private ClienteService clienteService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/clientes.txt");
        BufferedReader br = new BufferedReader(file);

        String line = br.readLine();
        String[] campos = null;

        while (line != null){
            campos = line.split(";");
            System.out.println(line);
            line = br.readLine();
            Cliente cliente =new Cliente();
            cliente.setNome(campos[0]);
            cliente.setCnpjOuCpf(campos[1]);
            cliente.setTelefone(campos[2]);
            cliente.setEmail(campos[3]);

            clienteService.incluir(cliente);

            line = br.readLine();
        }
        for(Cliente c : clienteService.obterLista()){
            System.out.println(c);
        }
        br.close();
    }
}
