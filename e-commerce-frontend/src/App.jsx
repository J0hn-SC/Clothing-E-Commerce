import { useState } from 'react'
import './App.css'
import HomePage from './customer/pages/HomePage/HomePage.jsx'
import Footer from './customer/components/Footer/Footer.jsx'
import Product from './customer/components/Product/Product.jsx'
import ProductDetails from './customer/components/ProductDetails/ProductDetails.jsx'
import Cart from './customer/components/Cart/Cart.jsx'
import Checkout from './customer/components/Checkout/Checkout.jsx'
import Order from './customer/components/Order/Order.jsx'
import OrderDetails from './customer/components/Order/OrderDetails.jsx'
import { Route, Routes } from 'react-router-dom'
import CustomerRouters from './Routers/CustomerRouters.jsx'
function App() {
  const [count, setCount] = useState(0)

  return (
    <div className='App'>
      <Routes>
        <Route path='/*' element={<CustomerRouters/>}></Route>
      </Routes>
    
    </div>
  )
}

export default App
