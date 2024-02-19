import { useState } from 'react'
import './App.css'
import Navigation from './customer/components/Navigation/Navigation.jsx'
import HomePage from './customer/pages/HomePage/HomePage.jsx'
import Footer from './customer/components/Footer/Footer.jsx'
import Product from './customer/components/Product/Product.jsx'
import ProductDetails from './customer/components/ProductDetails/ProductDetails.jsx'
import Cart from './customer/components/Cart/Cart.jsx'
function App() {
  const [count, setCount] = useState(0)

  return (
    <div className='App'>
    <Navigation></Navigation>
    <div>
      {//<HomePage></HomePage>
      //<Product/>
      //<ProductDetails/>
      }
      <Cart></Cart>
    </div>
    <Footer></Footer>
    </div>
  )
}

export default App
