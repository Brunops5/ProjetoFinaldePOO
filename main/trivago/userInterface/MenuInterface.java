package main.trivago.userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import main.trivago.entities.Cliente;
import main.trivago.entities.Hotel;
import main.trivago.entities.Quarto;
import main.trivago.entities.QuartoSuite;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Window.Type;

public class MenuInterface {

    private JFrame frmTrivagoGerente;
    private Hotel hotel;

    public static void setarQuartos(Hotel hotel) {
        hotel.iniciarQuartos(Hotel.MAX_TAM);
        hotel.inserirQuarto(new Quarto(0, 1, 0));
        hotel.inserirQuarto(new Quarto(1, 1, 0));
        hotel.inserirQuarto(new Quarto(2, 1, 0));
        hotel.inserirQuarto(new Quarto(3, 1, 0));
        hotel.inserirQuarto(new Quarto(4, 1, 0));
        hotel.inserirQuarto(new Quarto(5, 1, 0));
        hotel.inserirQuarto(new Quarto(6, 1, 0));
        hotel.inserirQuarto(new QuartoSuite(7, 2, 2, true, 1.5));
        hotel.inserirQuarto(new QuartoSuite(8, 2, 2, true, 1.5));
        hotel.inserirQuarto(new QuartoSuite(9, 2, 2, true, 1.5));
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuInterface window = new MenuInterface();
                    window.frmTrivagoGerente.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MenuInterface() {
        hotel = new Hotel();
        setarQuartos(hotel);
        initialize();
    }

    private void initialize() {
        frmTrivagoGerente = new JFrame();
        frmTrivagoGerente.setTitle("TRIVAGO GERENTE");
        frmTrivagoGerente.setBounds(100, 100, 213, 300);
        frmTrivagoGerente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmTrivagoGerente.getContentPane().setLayout(null);

        JButton checkinButton = new JButton("Check-in");
        checkinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkin();
            }
        });
        checkinButton.setBounds(28, 33, 117, 29);
        frmTrivagoGerente.getContentPane().add(checkinButton);

        JButton listarClientesButton = new JButton("Listar Clientes");
        listarClientesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarClientes();
            }
        });
        listarClientesButton.setBounds(28, 75, 117, 29);
        frmTrivagoGerente.getContentPane().add(listarClientesButton);

        JButton listarQuartosButton = new JButton("Listar Quartos");
        listarQuartosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarQuartos();
            }
        });
        listarQuartosButton.setBounds(28, 117, 117, 29);
        frmTrivagoGerente.getContentPane().add(listarQuartosButton);

        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkoutMenu();
            }
        });
        checkoutButton.setBounds(28, 159, 117, 29);
        frmTrivagoGerente.getContentPane().add(checkoutButton);

        JButton sairButton = new JButton("Sair");
        sairButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        sairButton.setBounds(28, 201, 117, 29);
        frmTrivagoGerente.getContentPane().add(sairButton);

        JLabel lblNewLabel = new JLabel("BEM VINDOS AO TRIVAGO");
        lblNewLabel.setBounds(20, 11, 161, 14);
        frmTrivagoGerente.getContentPane().add(lblNewLabel);
    }

    private void checkin() {

        if (!hotel.temVagas()) {
            JOptionPane.showMessageDialog(frmTrivagoGerente, "O hotel está cheio, não é possível realizar cadastro.");
            return;
        }

        // Colhendo informações do cliente
        String nome = JOptionPane.showInputDialog(frmTrivagoGerente, "Digite o nome do cliente:");
        int idade = Integer.parseInt(JOptionPane.showInputDialog(frmTrivagoGerente, "Digite a idade do cliente:"));
        String cpf = JOptionPane.showInputDialog(frmTrivagoGerente, "Digite o CPF do cliente:");
        char carro = JOptionPane.showInputDialog(frmTrivagoGerente, "O cliente possui carro? (S/N)").toUpperCase().charAt(0);
        char familia = JOptionPane.showInputDialog(frmTrivagoGerente, "O cliente possui familiares? (S/N)").toUpperCase().charAt(0);

        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setCarro(carro == 'S');
        cliente.setCpf(cpf);
        cliente.setFamilia(familia == 'S');
        cliente.setIdade(idade);

        do {
            int numeroQuarto = Integer.parseInt(JOptionPane.showInputDialog(frmTrivagoGerente, "Digite o número do quarto:"));
            if (hotel.isQuartoLivre(numeroQuarto)) {
                hotel.checkinCliente(cliente, numeroQuarto);
                JOptionPane.showMessageDialog(frmTrivagoGerente, "Cliente cadastrado com sucesso!");
                break;
            } else {
                JOptionPane.showMessageDialog(frmTrivagoGerente, "Quarto ocupado, digite outro número.");
            }
        } while (true);
    }

    private void listarClientes() {
        StringBuilder clientes = new StringBuilder();
        for (Quarto quarto : hotel.getQuartos()) {
            if (quarto.getCliente() != null) {
                clientes.append("#############################################\n");
                clientes.append("Quarto: ").append(quarto.getNumero()).append("\n");
                clientes.append("Valor Diária: R$").append(String.format("%.2f", quarto.getValorDiaria())).append("\n");
                clientes.append("Tipo: ").append(quarto instanceof QuartoSuite ? "Suite" : "Quarto").append("\n");
                clientes.append("Status: ").append(quarto.isOcupado() ? "Ocupado" : "Disponível").append("\n");
                clientes.append("Dados do cliente:\n");
                clientes.append("Nome: ").append(quarto.getCliente().getNome()).append("\n");
                clientes.append("Idade: ").append(quarto.getCliente().getIdade()).append("\n");
                clientes.append("CPF: ").append(quarto.getCliente().getCpf()).append("\n");
                clientes.append("Possui carro? ").append(quarto.getCliente().hasCarro() ? "Sim" : "Não").append("\n");
                clientes.append("Possui familiares? ").append(quarto.getCliente().hasFamilia() ? "Sim" : "Não").append("\n");
            }
        }
        JOptionPane.showMessageDialog(frmTrivagoGerente, clientes.toString(), "Lista de Clientes", JOptionPane.PLAIN_MESSAGE);
    }

    private void listarQuartos() {
        StringBuilder quartos = new StringBuilder();
        for (Quarto quarto : hotel.getQuartos()) {
            quartos.append(quarto instanceof QuartoSuite ? "Suite " : "Quarto ");
            quartos.append("N: ").append(quarto.getNumero());
            quartos.append(quarto.isOcupado() ? " Ocupado" : " Disponível");
            quartos.append("\n");
        }
        quartos.append("Vagas Estacionamento: ").append(hotel.getEstacionamento().getVagasLivres());
        JOptionPane.showMessageDialog(frmTrivagoGerente, quartos.toString(), "Lista de Quartos", JOptionPane.PLAIN_MESSAGE);
    }

    private void checkoutMenu() {
        int numeroQuarto = Integer.parseInt(JOptionPane.showInputDialog(frmTrivagoGerente, "Digite o número do quarto:"));

        if (hotel.isQuartoLivre(numeroQuarto)) {
            JOptionPane.showMessageDialog(frmTrivagoGerente, "Quarto vazio");
            return;
        }

        int horas = Integer.parseInt(JOptionPane.showInputDialog(frmTrivagoGerente, "Digite o tempo da estadia (em horas):"));

        double valorTotal = hotel.checkoutCliente(numeroQuarto, horas);
        JOptionPane.showMessageDialog(frmTrivagoGerente, "O valor total da estadia é: " + valorTotal);
        JOptionPane.showMessageDialog(frmTrivagoGerente, "O checkout foi realizado. Volte sempre!");
    }
}
