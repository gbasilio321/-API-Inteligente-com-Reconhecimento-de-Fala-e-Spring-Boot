package dio.budgeting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import dio.budgeting.domain.Category;
import dio.budgeting.domain.Transaction;

class TransactionTest {

    // Pega a primeira categoria que existir no enum Category.
    private final Category category = Category.values()[0];

    @Test
    void deveCriarTransacaoValida() {
        Transaction transaction = new Transaction("mercado", 5000, category);

        assertNotNull(transaction.getId());
        assertEquals("mercado", transaction.getDescription());
        assertEquals(5000, transaction.getAmount());
        assertEquals(category, transaction.getCategory());
    }

    @Test
    void naoDeveCriarTransacaoComValorNegativo() {
        assertThrows(IllegalArgumentException.class,
                () -> new Transaction("mercado", -10, category));
    }

    @Test
    void naoDeveCriarTransacaoComValorZero() {
        assertThrows(IllegalArgumentException.class,
                () -> new Transaction("mercado", 0, category));
    }

    @Test
    void naoDeveCriarTransacaoSemDescricao() {
        assertThrows(IllegalArgumentException.class,
                () -> new Transaction("   ", 5000, category));
    }

    @Test
    void naoDeveCriarTransacaoSemCategoria() {
        assertThrows(IllegalArgumentException.class,
                () -> new Transaction("mercado", 5000, null));
    }
}