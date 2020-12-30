package game;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Testovací třída pro komplexní otestování třídy {@link ListOfActions}.
 *
 * @author Jan Říha
 * @version ZS-2020, 2020-12-14
 */
public class ListOfActionsTest
{
    private static final IAction A_ACTION = new IAction()  // Vytvoříme si několik fiktivních příkazů s pevně
    {                                                      // danými názvy pomocí tzv. anonymních vnitřních tříd
        @Override
        public String execute(final String... parameters) {
            return null;
        }

        @Override
        public String getName() {
            return "a";
        }
    };

    private static final IAction B_ACTION = new IAction()
    {
        @Override
        public String execute(final String... parameters) {
            return null;
        }

        @Override
        public String getName() {
            return "b";
        }
    };

    private static final IAction C_ACTION = new IAction()
    {
        @Override
        public String execute(final String... parameters) {
            return null;
        }

        @Override
        public String getName() {
            return "c";
        }
    };

    private ListOfActions listOfActions;

    /**
     * Inicializační metoda, která vytváří tzv.&nbsp; 'testovací přípravek' <i>(inicializuje
     * datové atributy, které používá většina testů)</i>.
     */
    @Before
    public void setUp()
    {
        listOfActions = new ListOfActions();
        listOfActions.addAction(A_ACTION);
        listOfActions.addAction(C_ACTION);
    }

    /**
     * Test metod {@link ListOfActions#addAction(IAction) addAction} a
     * {@link ListOfActions#getAction(String) getAction}.
     */
    @Test
    public void testAddAndGetAction()
    {
        assertEquals(A_ACTION, listOfActions.getAction(A_ACTION.getName()));
        assertEquals(C_ACTION, listOfActions.getAction(C_ACTION.getName()));
        assertNull(listOfActions.getAction(B_ACTION.getName()));

        listOfActions.addAction(B_ACTION);

        assertEquals(B_ACTION, listOfActions.getAction(B_ACTION.getName()));

        assertNull(listOfActions.getAction(A_ACTION.getName().toUpperCase()));
    }

    /**
     * Test metod {@link ListOfActions#addAction(IAction) addAction} a
     * {@link ListOfActions#checkAction(String) checkAction}.
     */
    @Test
    public void testCheckAction()
    {
        assertTrue(listOfActions.checkAction(A_ACTION.getName()));
        assertTrue(listOfActions.checkAction(C_ACTION.getName()));
        assertFalse(listOfActions.checkAction(B_ACTION.getName()));

        listOfActions.addAction(B_ACTION);

        assertTrue(listOfActions.checkAction(B_ACTION.getName()));

        assertFalse(listOfActions.checkAction(A_ACTION.getName().toUpperCase()));
    }

    /**
     * Test metody {@link ListOfActions#getAllNames() getAllNames}.
     */
    @Test
    public void testGetAllNames()
    {
        assertEquals("a, c", listOfActions.getAllNames());

        listOfActions.addAction(B_ACTION);

        assertEquals("a, b, c", listOfActions.getAllNames());
    }
}
