package prova_4all;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class desafio_1 {
    @Test
    public void testCompraDeDoces(){
        // Abrindo o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\krnla\\drivers1\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().window().maximize();

        // Abrindo a página da loja
        navegador.get("https://shopcart-challenge.4all.com/");

        // Selecionar a categoria "Doces"
        navegador.findElement(By.id("open-categories-btn")).click();
        navegador.findElement(By.id("category-1")).click();

        // Adicionar todos os produtos ao carrinho
        navegador.findElement(By.id("add-product-4-btn")).click();
        navegador.findElement(By.id("add-product-5-btn")).click();

        // Ir para o carrinho
        navegador.findElement(By.id("cart-products-qtd")).click();

        // Aumentar a quantidade de brigadeiros para 4 unidades
        WebElement produto = navegador.findElement(By.id("add-product-4-qtd"));
        for (int i = 0; i <= 3; i++) {
            produto.click();
        }

        // Clicar em "Finalizar Compra"
        navegador.findElement(By.id("finish-checkout-button")).click();

        navegador.switchTo().activeElement();

        // Validar a mensagem "Pedido realizado com sucesso!"
        String mensagemExperada = "Pedido realizado com sucesso!";
        String mensagemExibida = navegador.findElement(By.cssSelector(".sc-dNLxif.jyncPa")).getText();
        assertEquals(mensagemExperada, mensagemExibida);

        // Clicar no botão "Fechar"
        navegador.findElement(By.className("close-modal")).click();

        // Fechar o navegador
        navegador.quit();

        System.out.println("\n\n\t SUCESSO: CENÁRIO CONCLUÍDO SEM ERROS");

    }
}
