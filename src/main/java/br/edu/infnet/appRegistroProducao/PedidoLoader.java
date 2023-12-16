package br.edu.infnet.appRegistroProducao;

import br.edu.infnet.appRegistroProducao.model.domain.Cliente;
import br.edu.infnet.appRegistroProducao.model.domain.Pedido;
import br.edu.infnet.appRegistroProducao.model.service.PedidoService;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

@Order(5)
@Component
public class PedidoLoader implements ApplicationRunner {
    @Autowired
    private PedidoService pedidoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            // Load the file from the classpath
            ClassPathResource resource = new ClassPathResource("files/pedidos.txt");
            InputStream inputStream = resource.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

            String line = br.readLine();
            String[] campos;

            while (line != null) {
                campos = line.split(";");
                System.out.println(line);

                Pedido pedido = new Pedido();
                try {
                    // ...
                    pedido.setDataPedido(LocalDate.parse(campos[0], DateTimeFormatter.ofPattern("dd/MM/yyyy").withLocale(new Locale("pt", "BR"))).atStartOfDay());
                    pedido.setDataEntrega(LocalDate.parse(campos[1], DateTimeFormatter.ofPattern("dd/MM/yyyy").withLocale(new Locale("pt", "BR"))).atStartOfDay());
                    // ...
                } catch (DateTimeParseException e) {
                    System.err.println("Error parsing date: ");
                    e.printStackTrace();
                }
                pedido.setPago(Boolean.parseBoolean(campos[4]));

                pedidoService.incluir(pedido);

                line = br.readLine();
            }

            for (Pedido pedido : pedidoService.obterLista()) {
                System.out.println(pedido);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
