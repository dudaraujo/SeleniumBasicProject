package br.ce.dudaraujo.suits;

import br.ce.dudaraujo.core.DriverFactory;
import br.ce.dudaraujo.page.LoginPage;
import br.ce.dudaraujo.test.*;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ContaTest.class,
        MovimentacaoTest.class,
        RemoverConta.class,
        SaldoTest.class,
        ResumoTest.class,
        ResumoVazioTest.class


})
public class SuitGeral {




}
