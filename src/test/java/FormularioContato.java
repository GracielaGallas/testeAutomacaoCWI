

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import suporte.Generator;
import suporte.Screenshot;

import java.util.concurrent.TimeUnit;


public class FormularioContato {

    @Test
    public void testPreencherFormulario() throws InterruptedException {
        //Abrindo o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Graciela\\drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        navegador.manage().window().maximize();

        //Navegando para a página da CWI
        navegador.get("https://www.cwi.com.br/");
        Screenshot.take(navegador, "C:\\Users\\Graciela\\TestReport\\cwi\\" + Generator.dataHoraParaArquivo() + "Pag.Inicial.png");

        //Clicar no link que possui o texto "Contato"
        navegador.findElement(By.linkText("Contato")).click();


        // Identificando o formulário de "Contato"
        WebElement formularioContato = navegador.findElement(By.linkText("clique aqui!"));
        Screenshot.take(navegador, "C:\\Users\\Graciela\\TestReport\\cwi\\" + Generator.dataHoraParaArquivo() + "Pag.Contato.png");

        // digitar no campo "Informe o assunto da mensagem" que está dentro do formulário de contato o texto "Teste Automação"
        navegador.findElement(By.id("Contact_Subject")).sendKeys("Teste Automação");

        //digitar no campo "nome" o nome "Graciela Gallas"
        navegador.findElement(By.id("Contact_Name")).sendKeys("Graciela Gallas");

        //digitar no campo "empresa" o texto "Nenhuma"
        navegador.findElement(By.id("Contact_Company")).sendKeys("Nenhuma");

        //digitar no campo "e-mail" o texto "graciela.carmen@gmail.com"
        navegador.findElement(By.id("Contact_Email")).sendKeys("graciela.carmen@gmail.com");

        //digitar no campo "telefone" o numero "51981420813"
        navegador.findElement(By.id("contact-phone")).sendKeys("51981420813");

        //digitar no campo "endereço" o texto "rua das flores 123"
        navegador.findElement(By.id("Contact_Address")).sendKeys("rua das flores 123");

        //digitar no campo "cidade" o texto "Porto Alegre"
        navegador.findElement(By.id("Contact_City")).sendKeys("Porto Alegre");

        //selecionar na comb de estados o valor "RS"
        navegador.findElement(By.xpath("//div[@id='select-state_iconselect']")).click();
        navegador.findElement(By.xpath("//div[@title='RS']")).click();

        //Escrever no campo "Mensagem" o texto "Teste de automação"
        navegador.findElement(By.id("Contact_Message")).sendKeys("Teste de automação da Graciela.");
        Screenshot.take(navegador, "C:\\Users\\Graciela\\TestReport\\cwi\\" + Generator.dataHoraParaArquivo() + "Formulario_preenchido.png");

        //clicar em "enviar mensagem"
        navegador.findElement(By.id("sendSubmit")).click();
        Screenshot.take(navegador, "C:\\Users\\Graciela\\TestReport\\cwi\\" + Generator.dataHoraParaArquivo() + "Enviado.png");

        // validar exibição de texto "Mensagem enviada com sucesso!"
        navegador.findElement(By.id("request-result"));
        Screenshot.take(navegador, "C:\\Users\\Graciela\\TestReport\\cwi\\" + Generator.dataHoraParaArquivo() + "Mensagem.png");


         System.out.println("Teste Executado com sucesso!");
         //fechar o navegador
         navegador.close();


    }
}