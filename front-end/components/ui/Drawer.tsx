import { Factory, Home, Package, Truck } from "lucide-react"
import Link from "next/link";

export default function Drawer() {
    const menuButtons = [
        {
            label: "Home",
            href: "/",
            icon: Home
        },
        {
            label: "Products",
            href: "/products",
            icon: Truck
        },
        {
            label: "Inputs",
            href: "/inputs",
            icon: Package
        }
    ]
    return(
        <div className="w-96 bg-blue-800 fixed h-screen p-4 flex flex-col align-items-start gap-20">
            <div className="flex gap-4 align-middle">
                <div className="bg-blue-600 w-16 h-16 rounded-md flex items-center justify-center">
                    <Factory fill="currentColor"/>
                </div>
                <div>
                    <span className="text-2xl font-bold text-white">Autodex</span>
                    <p className="text-sm">Gestão de produtos</p>
                </div>
            </div>
            <div className="flex gap-2 flex-col">
                {
                    menuButtons.map((button, index) => {
                        const Icon = button.icon;

                        return (
                            <Link href={button.href} key={index} className="p-4 text-white rounded-md hover:bg-gray-400 transition-all duration-200 cursor-pointer flex gap-5">
                                <Icon className="" fill="currentColor"/>
                                <span className="font-bold">{button.label}</span>
                            </Link>
                        )
                    })
                }
            </div>
        </div>
    )
}