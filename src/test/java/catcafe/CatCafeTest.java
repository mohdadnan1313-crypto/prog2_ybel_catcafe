package catcafe;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CatCafeTest {

    private CatCafe cafe;
    private FelineOverLord cat1;
    private FelineOverLord cat2;
    private FelineOverLord cat3;

    @BeforeEach
    void setUp() {
        // given
        cafe = new CatCafe();
        cat1 = new FelineOverLord("Mimi", 3);
        cat2 = new FelineOverLord("Luna", 5);
        cat3 = new FelineOverLord("Max", 7);
    }

    @Test
    void testNewCafeIsEmpty() {
        // given
        CatCafe emptyCafe = new CatCafe();
        // when
        long count = emptyCafe.getCatCount();
        // then
        assertEquals(0, count);
    }

    @Test
    void testAddOneCat() {
        // given - cafe is empty
        // when
        cafe.addCat(cat1);
        // then
        assertEquals(1, cafe.getCatCount());
    }

    @Test
    void testAddMultipleCats() {
        // given - cafe is empty
        // when
        cafe.addCat(cat1);
        cafe.addCat(cat2);
        cafe.addCat(cat3);
        // then
        assertEquals(3, cafe.getCatCount());
    }

    @Test
    void testGetCatByNameFound() {
        // given
        cafe.addCat(cat1);
        // when
        FelineOverLord result = cafe.getCatByName("Mimi");
        // then
        assertEquals(cat1, result);
    }

    @Test
    void testGetCatByNameNotFound() {
        // given
        cafe.addCat(cat1);
        // when
        FelineOverLord result = cafe.getCatByName("Unknown");
        // then
        assertNull(result);
    }

    @Test
    void testGetCatByNameNull() {
        // given
        cafe.addCat(cat1);
        // when
        FelineOverLord result = cafe.getCatByName(null);
        // then
        assertNull(result);
    }

    @Test
    void testGetCatByWeightFound() {
        // given
        cafe.addCat(cat1);
        cafe.addCat(cat2);
        // when
        FelineOverLord result = cafe.getCatByWeight(4, 6);
        // then
        assertEquals(cat2, result);
    }

    @Test
    void testGetCatByWeightNotFound() {
        // given
        cafe.addCat(cat1);
        // when
        FelineOverLord result = cafe.getCatByWeight(10, 20);
        // then
        assertNull(result);
    }

    @Test
    void testGetCatByWeightNegativeMin() {
        // given
        cafe.addCat(cat1);
        // when
        FelineOverLord result = cafe.getCatByWeight(-1, 5);
        // then
        assertNull(result);
    }

    @Test
    void testGetCatByWeightMaxLessThanMin() {
        // given
        cafe.addCat(cat1);
        // when
        FelineOverLord result = cafe.getCatByWeight(5, 3);
        // then
        assertNull(result);
    }

    @Test
    void testAddNullCatThrowsException() {
        // given - cafe is empty
        // when + then
        assertThrows(NullPointerException.class, () -> cafe.addCat(null));
    }
}