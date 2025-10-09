import { createRouter, createWebHistory } from 'vue-router'

const routes = [{
  path: '/',
  component: () => import('../views/MainPage.vue'),
  children: [{
    path: 'welcome',
    component: () => import('../views/MainPage/WelcomePage.vue'),
  }, {
    path: 'about',
    component: () => import('../views/MainPage/AboutPage.vue'),
  }, {
    path: 'base/',
    children: [{
      path: 'station',
      component: ()=> import('../views/MainPage/base/StationPage.vue'),
    }, {
      path: 'train',
      component: ()=> import('../views/MainPage/base/TrainPage.vue'),
    }, {
      path: 'train-station',
      component: ()=> import('../views/MainPage/base/Train-stationPage.vue'),
    }, {
      path: 'train-carriage',
      component: ()=> import('../views/MainPage/base/Train-carriagePage.vue'),
    }, {
      path: 'train-seat',
      component: ()=> import('../views/MainPage/base/Train-seatPage.vue'),
    }]
  }, {
    path: 'member/',
    children: [{
      path: 'ticket',
      component: ()=> import('../views/MainPage/member/TicketPage.vue')
    }]
  }, {
    path: 'business/',
    children: [{
      path: 'daily-train',
      component: ()=>import('../views/MainPage/business/Daily-trainPage.vue')
    },{
      path: 'daily-train-station',
      component: ()=>import('../views/MainPage/business/Daily-train-stationPage.vue')
    },{
      path: 'daily-train-carriage',
      component: ()=>import('../views/MainPage/business/Daily-train-carriagePage.vue')
    },{
      path: 'daily-train-seat',
      component: ()=>import('../views/MainPage/business/Daily-train-seatPage.vue')
    },{
      path: 'daily-train-ticket',
      component: ()=>import('../views/MainPage/business/Daily-train-ticketPage.vue')
    },{
      path: 'confirm-order',
      component: ()=>import('../views/MainPage/business/Confirm-orderPage.vue')
    }]
  }, {
    path: 'batch/',
    children: [{
      path: 'job',
      component: ()=> import('../views/MainPage/batch/JobPage.vue')
    }]
  }]
}, {
  path: '',
  redirect: '/welcome'
}];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
