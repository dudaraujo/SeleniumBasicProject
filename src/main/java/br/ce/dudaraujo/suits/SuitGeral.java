package br.ce.dudaraujo.suits;

import br.ce.dudaraujo.test.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ContaTest.class,
        MovimentacaoTest.class,
        RemoverConta.class,
        SaldoTest.class,
        ResumoTest.class


})
public class SuitGeral {


}
