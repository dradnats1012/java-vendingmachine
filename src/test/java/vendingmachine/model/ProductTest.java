package vendingmachine.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ProductTest {
    @Test
    void purchase를_호출하면_amount_1_감소() {
        Product product = new Product("콜라", 1000, 1);
        product.purchase();
        Assertions.assertEquals(0, product.getAmount());
    }

    @Test
    void 가격이_100_이하면_오류() {
        assertThatThrownBy(() -> new Product("콜라", 90, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 가격이_10_배수가_아니면_오류() {
        assertThatThrownBy(() -> new Product("콜라", 101, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 수량이_0보다_작거나_같으면_오류() {
        assertThatThrownBy(() -> new Product("콜라", 100, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
