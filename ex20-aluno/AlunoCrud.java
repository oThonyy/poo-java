import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class AlunoCrud {
    
    public class Aluno {
        private String id;
        private String ra;
        private String nome;
        private String nascimento;

        public String getId() {
            return this.id;
        }
        public void setId(String valor) {
            this.id = valor;
        }

        public String getRa() {
            return this.ra;
        }
        public void setRa(String valor) {
            this.ra = valor;
        }

        public String getNome() {
            return this.nome;
        }
        public void setNome(String valor) {
            this.nome = valor;
        }

        public String getNascimento() {
            return this.nascimento;
        }
        public void setNascimento(String valor) {
            this.nascimento = valor;
        }

    }

    public class AlunoControl {
     
        private List<Aluno> lista = new ArrayList<>();
    
        public void gravar (Aluno a) {
            lista.add(a);
        }
    
        public Aluno pesquisarPorNome(String parteNome) {
            for (Aluno a : lista) {
                if (a.getNome().contains(parteNome)) {
                    return a;
                }
            }
            return null;
        }
    }

    public class AlunoBoundary extends Application{

        private TextField txtId = new TextField();
        private TextField txtRa = new TextField();
        private TextField txtNome = new TextField();
        private TextField txtNascimento = new TextField();
        private AlunoControl control = new AlunoControl();

        @Override
        public void start(Stage stage){
            GridPane pane = new GridPane();
            ColumnConstraints col30 = new ColumnConstraints();
            col30.setPercentWidth(30.0);
            ColumnConstraints col70 = new ColumnConstraints();
            col30.setPercentWidth(70.0);
            pane.getColumnConstraints().addAll( col30, col70 );

            RowConstraints row25 = new RowConstraints();
            row25.setPercentHeight(25.0);
            pane.getRowConstraints().addAll(row25, row25, row25, row25);

            Scene scn = new Scene(pane, 600, 400);

            pane.add(new Label("ID: "), 0, 0);
            pane.add(txtId, 1, 0);
            pane.add(new Label("RA: "), 0, 1);
            pane.add(txtRa, 1, 1);
            pane.add(new Label("Nome: "), 0, 2);
            pane.add(txtNome, 1, 2);
            pane.add(new Label("Nascimento: "), 0, 3);
            pane.add(txtNascimento, 1, 3);

            Button btnGravar = new Button();
            Button btnPesquisar = new Button();

            btnGravar.setOnAction(e -> {
                Aluno a = telaParaAluno();
                control.gravar(a);
                Alert alert = new Alert(AlertType.INFORMATION, 
                    "Aluno gravado com sucesso");
                alert.showAndWait();
                txtId.setText("");
                txtRa.setText("");
                txtNome.setText("");
                txtNascimento.setText("");
            });

            btnPesquisar.setOnAction(e -> {
                Aluno a = control.pesquisarPorNome(txtNome.getText());
                if (a == null) {
                    Alert alert = new Alert(AlertType.WARNING, 
                        "Não há alunos com este nome");
                    alert.showAndWait();
                } else {
                    alunoParaTela(a);
                }
            });

            pane.add(btnGravar, 0, 3);
            pane.add(btnPesquisar, 0, 3);

            stage.setScene(scn);
            stage.setTitle("Lista de Alunos");
            stage.show();
        }        
        
        public void main (String[] args) {
            Application.launch(AlunoBoundary.class, args);
        }

        public Aluno telaParaAluno() {
            Aluno a = new Aluno();
            a.setId(txtId.getText());
            a.setRa(txtRa.getText());
            a.setNome(txtRa.getText());
            a.setNascimento(txtNascimento.getText());
            return a;
        }

        public void alunoParaTela(Aluno a) {
            if (a != null) {
                txtId.setText(a.getId());
                txtRa.setText(a.getId());
                txtNome.setText(a.getNome());
                txtNascimento.setText(a.getNascimento());
            }
        }
    }
}
