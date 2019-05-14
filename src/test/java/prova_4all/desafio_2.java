package prova_4all;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class desafio_2 {
    @Test
    public void TesteCompraBebidas (){

        // Abrir o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\krnla\\drivers1\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().window().maximize();


        // Abrir o site da loja
        navegador.get("https://shopcart-challenge.4all.com/");

        // Selecionar a categoria "Bebidas"
        navegador.findElement(By.id("open-categories-btn")).click();
        navegador.findElement(By.id("category-0")).click();

        // Adicionar todos os produtos ao carrinho
        navegador.findElement(By.id("add-product-0-btn")).click();
        navegador.findElement(By.id("add-product-1-btn")).click();
        navegador.findElement(By.id("add-product-2-btn")).click();

        // Selecionar a categoria "Todos"
        navegador.findElement(By.id("open-categories-btn")).click();
        navegador.findElement(By.id("category-all")).click();

        // Adicionar o produto "Rissole médio" ao carrinho
        navegador.findElement(By.id("add-product-3-btn")).click();

        // Acessar o carrinho
        navegador.findElement(By.id("cart-btn")).click();

        // Aumentar a quantidade do produto "Rissole médio" em 9 unidades
        WebElement produto = navegador.findElement(By.id("add-product-3-qtd"));
        for (int i = 0; i < 8; i++) {
            produto.click();
        }

        // Diminuir a quantidade do produto "Rissole médio" em 5 unidades
        WebElement produtoRemove = navegador.findElement(By.id("remove-product-3-qtd"));
        for (int i = 0; i < 5; i++) {
            produtoRemove.click();
        }

        // Validar o valor total dos produtos
        WebElement totalPrice = navegador.findElement(By.id("price-total-checkout"));
        String valorCompraPrice = totalPrice.getText();
        assertEquals("R$ 30,50", valorCompraPrice);

        // Clicar no botão "Finalizar Compra"
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
