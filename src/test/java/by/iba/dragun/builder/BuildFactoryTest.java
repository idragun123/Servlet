package by.iba.dragun.builder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class BuildFactoryTest {
    private static final String USER = "user";
    private static final String PERSON = "person";
    private static final Class USER_BUILDER = UserBuilder.class;
    private static final Class PERSON_BUILDER = PersonBuilder.class;

    @Test
    @UseDataProvider("dataForBuilderCreator")
    public void shouldCreateAndReturnAppropriateBuilder(Class Builder, String BuilderName) {
        Builder builder = BuilderFactory.create(BuilderName);
        Class<? extends Builder> builderClass = builder.getClass();
        assertEquals(Builder, builderClass);
    }
    @DataProvider
    public static Object[][] dataForBuilderCreator() {
        return new Object[][]{
                {USER_BUILDER,USER},
                {PERSON_BUILDER, PERSON},
        };
    }
}



