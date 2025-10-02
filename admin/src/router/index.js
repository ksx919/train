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
    component: ()=> import('../views/MainPage/StationPage.vue')
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
