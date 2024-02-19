import React from 'react'
import { Route, Routes } from 'react-router-dom'
import HomePage from '../customer/pages/HomePage/HomePage'
import Navigation from '../customer/components/Navigation/Navigation'
import Footer from '../customer/components/Footer/Footer'
import Cart from '../customer/components/Cart/Cart'
import Product from '../customer/components/Product/Product'

const CustomerRouters = () => {
  return (
    <div>
        <div>
        <Navigation></Navigation>
        </div>
        <Routes>
            <Route path='/' element={<HomePage/>}></Route>
            <Route path='/cart' element={<Cart/>}></Route>
            <Route path='/:labelOne/:labelTwo/:labelThree' element={<Product/>}></Route>
            
            {//<HomePage></HomePage>
      //<Product/>
      //<ProductDetails/>
      //<Cart></Cart>
      //<Checkout></Checkout>
      //<Order></Order>
      //<OrderDetails/>
            }
        </Routes>
        <div>
            <Footer></Footer>
        </div>
    </div>
  )
}

export default CustomerRouters