package br.edu.infnet.appRegistroProducao;

import br.edu.infnet.appRegistroProducao.model.domain.Artesao;
import br.edu.infnet.appRegistroProducao.model.domain.Pedido;
import br.edu.infnet.appRegistroProducao.model.domain.Producao;
import br.edu.infnet.appRegistroProducao.model.domain.Produto;
import br.edu.infnet.appRegistroProducao.model.service.ProducaoService;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Locale;

@Order(6)
@Component
public class ProducaoLoader implements ApplicationRunner {
    @Autowired
    private ProducaoService producaoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            // Load the file from the classpath
            ClassPathResource resource = new ClassPathResource("files/producao.txt");
            InputStream inputStream = resource.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

            String line = br.readLine();
            String[] campos;

            while (line != null) {
                campos = line.split(";");
                System.out.println(line);

                Pedido pedido = new Pedido();
                pedido.setIdPedido(Integer.valueOf(campos[4]));

                Artesao artesao = new Artesao();
                artesao.setIdArtesao(Integer.valueOf(campos[3]));
                Producao producao = new Producao();
                try {
                    producao.setDataInicio(LocalDate.parse(campos[0], DateTimeFormatter.ofPattern("dd/MM/yyyy").withLocale(new Locale("pt", "BR"))).atStartOfDay());
                    producao.setDataFinal(LocalDate.parse(campos[1], DateTimeFormatter.ofPattern("dd/MM/yyyy").withLocale(new Locale("pt", "BR"))).atStartOfDay());
                } catch (DateTimeParseException e) {
                    System.err.println("Error parsing date: ");
                    e.printStackTrace();
                }
                producao.setArtesao(artesao);
                producao.setPedido(pedido);
                producao.setProdutos(new ArrayList<Produto>());
                producaoService.incluir(producao);

                line = br.readLine();
            }

            for (Producao producao : producaoService.obterLista()) {
                System.out.println(producao);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
