package com.gfcorrea.listadetarefas;


import static junit.framework.TestCase.assertEquals;

import com.gfcorrea.listadetarefas.repository.TarefaRepository;
import com.gfcorrea.listadetarefas.viewmodel.ResumoViewModel;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ResumoViewModelTest {


    @Mock private ResumoViewModel resumoViewModel;

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void ResumoViewModelTest(){
        resumoViewModel.setA(3);

        assertEquals(3,  resumoViewModel.getA() );
    }

}
