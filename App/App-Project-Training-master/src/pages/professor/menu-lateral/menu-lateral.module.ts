import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { MenuLateralPage } from './menu-lateral';

@NgModule({
  declarations: [
    MenuLateralPage
  ],
  imports: [
    IonicPageModule.forChild(MenuLateralPage),
  ],
  exports: [
    MenuLateralPage
  ]
})
export class MenuLateralPageModule {}
