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
    path: 'business/',
    children: [{
      path: 'daily-train',
      component: ()=>import('../views/MainPage/business/Daily-trainPage.vue')
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
