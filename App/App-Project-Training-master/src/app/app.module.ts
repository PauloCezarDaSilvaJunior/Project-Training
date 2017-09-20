import { cadastroProfessorPageModule } from './../pages/cadastro-professor/cadastro-professor.module';
import { ProfessorTabsPageModule } from './../pages/professor/professor-tabs/professor-tabs.module';
import { PerfilAlunoPageModule } from './../pages/professor/alunos/perfil-aluno/perfil-aluno.module';
import { LocalService } from './../providers/local/login.service';
import { TreinamentosPage } from './../pages/professor/treinamentos/treinamentos';
import { ExerciciosPage } from './../pages/professor/exercicios/exercicios';
import { AlunosPage } from './../pages/professor/alunos/alunos';
import { cadastroAlunoPageModule } from './../pages/cadastro-aluno/cadastro-aluno.module';
import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { SplashScreen } from '@ionic-native/splash-screen';
import { StatusBar } from '@ionic-native/status-bar';

import { MyApp } from './app.component';
import { LoginPage } from '../pages/login/login';
import { HttpModule } from '@angular/http';
import { RlTagInputModule } from 'angular2-tag-input';
import { MenuLateralPageModule } from '../pages/professor/menu-lateral/menu-lateral.module';
import { ImagensComponent } from '../components/imagens/imagens';
import { CadastroExerciciosPageModule } from '../pages/professor/exercicios/cadastro-exercicios/cadastro-exercicios.module';
import { AuthService } from '../providers/auth-service/auth-service';

@NgModule({
  declarations: [
    MyApp,
    LoginPage,
    AlunosPage,
    ExerciciosPage,
    TreinamentosPage,
    ImagensComponent,
  ],
  imports: [
    BrowserModule, HttpModule,
    cadastroProfessorPageModule,
    cadastroAlunoPageModule,
    CadastroExerciciosPageModule,
    IonicModule.forRoot(MyApp),
    RlTagInputModule,
    PerfilAlunoPageModule,
    MenuLateralPageModule,
    ProfessorTabsPageModule,
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    LoginPage,
    AlunosPage,
    ExerciciosPage,
    TreinamentosPage,
  ],
  providers: [
    StatusBar,
    SplashScreen,
    { provide: ErrorHandler, useClass: IonicErrorHandler },
    AuthService,
    LocalService
  ],
})
export class AppModule { }
