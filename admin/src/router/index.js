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
    path: 'station',
    component: ()=> import('../views/MainPage/StationPage.vue'),
  }, {
    path: 'train',
    component: ()=> import('../views/MainPage/TrainPage.vue'),
  }, {
    path: 'train-station',
    component: ()=> import('../views/MainPage/Train-stationPage.vue'),
  }, {
    path: 'train-carriage',
    component: ()=> import('../views/MainPage/Train-carriagePage.vue'),
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
